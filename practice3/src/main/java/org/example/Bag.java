package org.example;

public class Bag {
    private Integer id;
    private String material;
    private String brand;
    private String country;
    private Integer height;
    private Integer width;
    private Integer depth;

    public Bag() {
    }

    public Bag(Integer id, String material, String brand, String country, Integer height, Integer width, Integer depth) {
        this.id = id;
        this.material = material;
        this.brand = brand;
        this.country = country;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getId() {
        return id;
    }

    public String getMaterial() {
        return material;
    }

    public String getBrand() {
        return brand;
    }

    public String getCountry() {
        return country;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "Сумка под номером " + id + "\n" +
                "Материал: "  + material + "\n" +
                "Бренд: "  + brand + "\n" +
                "Страна изготовитель: "  + country + "\n" +
                "Высота: "  + height + "\n" +
                "Ширина: "  + width + "\n" +
                "Глубина: "  + depth;
    }
}
