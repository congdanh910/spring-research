package com.demo.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CapturesServletResponse extends HttpServletResponseWrapper
		implements ServletResponse {
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	private PrintWriter cachedWriter;
	private ServletOutputStream captureOutputStream = null;
	private int status = HttpServletResponse.SC_OK;
	private String encoding;
	private String contentType = "text/html";

	public CapturesServletResponse(HttpServletResponse response) {
		super(response);
		encoding = response.getCharacterEncoding();
	}

	public byte[] getResponseData() throws IOException {
		getWriter().flush();
		return out.toByteArray();
	}

	public String getResponseAsString() throws IOException {
		getWriter().flush();
		try {
			return out.toString(encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public void addCookie(Cookie arg0) {
	}

	public void addDateHeader(String arg0, long arg1) {
	}

	public void addHeader(String arg0, String arg1) {
	}

	public void addIntHeader(String arg0, int arg1) {
	}

	public void sendError(int status, String arg1) throws IOException {
		this.status = status;
	}

	public void sendError(int status) throws IOException {
		this.status = status;
	}

	public void sendRedirect(String arg0) throws IOException {

	}

	public void setDateHeader(String arg0, long arg1) {

	}

	public void setHeader(String arg0, String arg1) {

	}

	public void setIntHeader(String arg0, int arg1) {

	}

	public void setStatus(int status, String arg1) {
		this.status = status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void flushBuffer() throws IOException {
		// System.out.println("flushBuffer");
	}

	public String getContentType() {

		return contentType;
	}

	public ServletOutputStream getOutputStream() throws IOException {
		// System.out.println("getOutputStream");
		// Pass this faked servlet output stream that captures what is sent
		/*
		 * if (cacheOut == null) { cacheOut = new
		 * SplitServletOutputStream(result.getOutputStream(),
		 * super.getOutputStream()); }
		 * 
		 * return cacheOut;
		 */
		if (captureOutputStream == null) {
			final OutputStream os = out;
			captureOutputStream = new ServletOutputStream() {

				public void write(int b) throws IOException {
					os.write(b);
					// System.out.write(b);
				}

				public void flush() throws IOException {
					os.flush();
				}

			};
		}
		return captureOutputStream;
	}

	public PrintWriter getWriter() throws IOException {
		// System.out.println("getWriter");
		if (cachedWriter == null) {
			cachedWriter = new PrintWriter(new OutputStreamWriter(
					getOutputStream(), encoding));
		}

		return cachedWriter;
	}

	public boolean isCommitted() {
		return false;
	}

	public void reset() {
		// System.out.println("reset");
		out.reset();
		status = HttpServletResponse.SC_OK;
		encoding = getResponse().getCharacterEncoding();
		contentType = "text/html";
	}

	public void resetBuffer() {
		// System.out.println("resetBuffer");
		out.reset();
	}

	public void setCharacterEncoding(String encoding) {
		setEncoding(encoding);
		// System.out.println("setCharacterEncoding:"+encoding);
	}

	public void setContentLength(int arg0) {
	}

	public void setContentType(String value) {
		// System.out.println("setContentType:"+value);
		contentType = value;
		if (value != null) {
			int pos = value.indexOf("charset=");
			if (pos != -1) {
				String charset = value.substring(pos + "charset=".length());
				setEncoding(charset);
			}
		}
	}

	private void setEncoding(String encoding) {
		// if(cachedWriter!=null) throw new
		// IllegalStateException("encoding cannot be set after PrintWriter has been called");
		if (cachedWriter != null && this.encoding != null
				&& !this.encoding.equals(encoding)) {
			// new Throwable("attempt to change encoding from " + this.encoding
			// + " to " + encoding).printStackTrace();
			throw new IllegalStateException(
					"encoding cannot be set after PrintWriter has been called. Attempt to change encoding from "
							+ this.encoding + " to " + encoding);
		}
		this.encoding = encoding;
	}

	public int getStatus() {

		return status;
	}
}
