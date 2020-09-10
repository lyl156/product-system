package com.example.crud.Tools;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.IOException;
import java.io.InputStream;

//impl interface ServletInputStream
//attribute InputStream for ByteArrayInputStream
public class AdaptorServletInputStream extends ServletInputStream {

    // decorator
    private InputStream stream;

    public AdaptorServletInputStream(InputStream stream) {
        this.stream = stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    @Override
    public int read() throws IOException {
        return stream.read();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener readListener) {

    }
}
