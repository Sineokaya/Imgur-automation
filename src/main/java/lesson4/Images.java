package lesson4;

public enum Images {
    IMAGE_FILE1("src/test/resources/img.png"),
    PNG_1_1("src/test/resources/Images/1_1.png"),
    TIFF_50mb("src/test/resources/Images/50+mb.tif"),
    IMAGE_URL("http://img1.liveinternet.ru/images/attach/c/11/127/974/127974421_4264148_Ummy_Video_Downloader1.jpg"),
    TIFF_BIG50("src/test/resources/Images/big50+.tif"),
    DEBUG_LOG("src/test/resources/Images/debug.log"),
    DIG10K_BMP("src/test/resources/Images/dig10k_penguin.bmp"),
    DNS_HTML("src/test/resources/Images/dns.html"),
    IMG2_PNG("src/test/resources/Images/img2.png"),
    IMG3_PNG("src/test/resources/Images/img3.png"),
    IT_JPG("src/test/resources/Images/IT.jpg"),
    NORMAL_MP4("src/test/resources/Images/normal.mp4"),
    SMALL_MP4("src/test/resources/Images/small.mp4"),
    BIG_MP4("src/test/resources/Images/big.mp4"),
    TEST_DOCX("src/test/resources/Images/Test.docx"),
    TIFF_TIF("src/test/resources/Images/tiff.tif"),
    TIGER("src/test/resources/Images/tiger-clip-art-23.png"),
    TX2Q("src/test/resources/Images/Tx2q.gif"),
    ZAMENA("src/test/resources/Images/Замена_проходки.pdf");

    private String path;
    Images(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
