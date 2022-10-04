package ru.sfu.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import ru.sfu.dao.BagDAO;

public class Bag {
    private int id;
    @NotEmpty(message = "material should not be empty")
    @Size(min = 2, max = 30, message = "material should be between 2 and 30 characters")
    private String material;
    @NotEmpty(message = "brand should not be empty")
    @Size(min = 2, max = 30, message = "brand should be between 2 and 30 characters")
    private String brand;
    @NotEmpty(message = "country should not be empty")
    @Size(min = 2, max = 30, message = "country should be between 2 and 30 characters")
    private String country;
    @Min(value = 0, message = "height should be greater than 0")
    private int height;
    @Min(value = 0, message = "height should be greater than 0")
    private int width;
    @Min(value = 0, message = "height should be greater than 0")
    private int depth;

    public Bag() {

    }

    public Bag(int id, String material, String brand, String country, int height, int width, int depth) {
        this.id = id;
        this.material = material;
        this.brand = brand;
        this.country = country;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
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
