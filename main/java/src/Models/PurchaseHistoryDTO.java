package Models;


public class PurchaseHistoryDTO {
	private int id;
    private String clientName;
    private String movieName;
    private Integer quantity;
    private Double price;
    
	public PurchaseHistoryDTO() {}


    public PurchaseHistoryDTO(int id, String clientName, String movieName, Integer quantity, Double price) {
    	this.id = id;
        this.clientName = clientName;
        this.movieName = movieName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters y setters
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public int getId() {
    	return this.id;
    }
}