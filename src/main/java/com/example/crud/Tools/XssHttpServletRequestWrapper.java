package com.example.crud.Tools;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;


@Slf4j
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    Logger logger = LoggerFactory.getLogger("XssHttpServletRequestWrapper");
    private HttpServletRequest orgRequest = null;
    private static final Whitelist whitelist = new Whitelist();

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        orgRequest = request;
    }

    public HttpServletRequest getOrgRequest() {
        return orgRequest;
    }

    public String clean(String content) {
        String result = Jsoup.clean(content, whitelist);
        if (!content.equals(result)) {
            logger.warn("content is: " + content + "  cleaned result: " + result);
        }
        return result;
    }

    //For post method, @RequestBody
    @Override
    public ServletInputStream getInputStream() throws IOException {
        //Java IO use decorator
        //InputStream get byte; reader get char;  InputStreamReader : from byte to char
        // chinese(Unicode) use Reader
        //use reader since I want modify char latter.
        BufferedReader br = new BufferedReader(new InputStreamReader(orgRequest.getInputStream()));

        String line = br.readLine();
        StringBuffer sb = new StringBuffer();
        if (line != null) {
            sb.append(clean(line));
        }

        return new AdaptorServletInputStream(new ByteArrayInputStream(sb.toString().getBytes()));
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (StringUtils.isNotBlank(value)) {
            value = clean(value);
        }
        return value;
    }

    //one parameter has many values(e.g. multiple choice)
    @Override
    public String[] getParameterValues(String name) {
        String[] strings = super.getParameterValues(name);
        if (strings != null) {
            for (int i = 0; i < strings.length; i++) {
                strings[i] = clean(strings[i]);
            }
        }
        return strings;
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (StringUtils.isNotBlank(value)) {
            value = clean(value);
        }
        return value;
    }

}
