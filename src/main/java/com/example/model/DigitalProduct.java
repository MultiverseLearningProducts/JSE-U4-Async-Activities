package com.example.model;

/**
 * DigitalProduct class - Represents a digital product that extends the base Product class.
 * This class demonstrates inheritance by adding specialized fields and overriding methods.
 *
 * @author Student Developer
 * @version 1.0.0
 */
public class DigitalProduct extends Product {
    private String downloadUrl;
    private String fileType; // e.g., PDF, MP3, MP4
    private double fileSizeMB; // in megabytes

    /**
     * Default constructor for DigitalProduct.
     */
    public DigitalProduct() {
        super(); // Calls the default constructor of the Product parent class
    }

    /**
     * Constructor for DigitalProduct with all fields.
     *
     * @param name The name of the digital product.
     * @param price The price of the digital product.
     * @param sku The SKU (Stock Keeping Unit) of the digital product.
     * @param downloadUrl The URL from which the product can be downloaded.
     * @param fileType The type of the digital file (e.g., PDF, MP3).
     * @param fileSizeMB The size of the digital file in megabytes.
     */
    public DigitalProduct(String name, double price, String sku, String downloadUrl, String fileType, double fileSizeMB) {
        super(name, price, sku); // Calls the constructor of the Product parent class
        this.downloadUrl = downloadUrl;
        this.fileType = fileType;
        this.fileSizeMB = fileSizeMB;
    }

    // Getter for downloadUrl
    public String getDownloadUrl() {
        return downloadUrl;
    }

    // Setter for downloadUrl
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    // Getter for fileType
    public String getFileType() {
        return fileType;
    }

    // Setter for fileType
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    // Getter for fileSizeMB
    public double getFileSizeMB() {
        return fileSizeMB;
    }

    // Setter for fileSizeMB
    public void setFileSizeMB(double fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
    }

    /**
     * Overrides the displayInfo method from the Product class to include digital product specific information.
     * This demonstrates method overriding, a key aspect of inheritance.
     */
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the parent's displayInfo to reuse common info
        System.out.println("Download URL: " + getDownloadUrl());
        System.out.println("File Type: " + getFileType());
        System.out.println("File Size: " + getFileSizeMB() + " MB");
        System.out.println("Type: Digital Product");
        System.out.println("Description: This is a digital item that can be downloaded instantly");
    }

    /**
     * A specialized method for digital products to provide download instructions.
     */
    public void downloadInstructions() {
        System.out.println("=== Download Instructions ===");
        System.out.println("1. Click the download link: " + getDownloadUrl());
        System.out.println("2. Save the file to your device");
        System.out.println("3. Open the file using appropriate software");
        System.out.println("4. Enjoy your digital product!");
    }
}
