package com.company.facade;

public class SftpClient {
    private Ftp ftp;
    private Reader reader;
    private Writer writer;

    public SftpClient(Ftp ftp, Reader reader, Writer writer) {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }

    public SftpClient(String host, int port, String path, String fileName) {
        this.ftp = new Ftp(host, port, path);
        this.writer = new Writer(fileName);
        this.reader = new Reader(fileName);
    }

    public void connect() {
        ftp.connect();
        ftp.moveDirectory();

        writer.fileconnect();
        reader.fileConnect();
    }

    public void disconnect() {
        writer.fileDisconnect();
        reader.fileDisconnect();
        ftp.disConnect();
    }

    public void read() {
        reader.fileRead();
    }

    public void write() {
        writer.write();
    }
}
