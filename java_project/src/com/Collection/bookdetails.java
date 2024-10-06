package com.Collection;

public class bookdetails {
    private int id;
    private String name;
    private String author;
    private double price;

    public bookdetails(int id, String name, String author, double price) {
        this.id = id;
        this.name = name;
        this.author=author;
        this.price = price;
    }

    public int getId() {
		return id;
	}

	public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

	public String getAuthor() {
		return author;
	}

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

	public void setAuthor(String author) {
		this.author = author;
	}
}
