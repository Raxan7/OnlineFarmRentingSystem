package admin;

public class farmDisplayConstructor {
    public int id;
    public String location;
    public String desscription;
    public String image;
    public String farm_size;
    public String farm_price;
    public String status;
    public String sales_status;
    public String contact;
    
    public farmDisplayConstructor(int id,String location,String desscription,String image,String farm_size,String farm_price,String status,String sales_status,String contact){
    this.id=id;
    this.location=location;
    this.desscription=desscription;
    this.image=image;
    this.farm_size=farm_size;
    this.farm_price=farm_price;
    this.status=status;
    this.sales_status=sales_status;
    this.contact=contact;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
    return this.id;
    }
    public void setLocation(String location){
    this.location=location;
    }
    public void setDesscription(String desscription){
    this.desscription=desscription;
    }
    public void setImage(String image){
    this.image=image;
    }
    public void setfarm_size(String farm_size){
    this.farm_size=farm_size;
    }
    public void setfarm_price(String farm_price){
    this.farm_price=farm_price;
    }
    public void setSales_status(String sales_status){
    this.sales_status=sales_status;
    }
    public void setContact(String contact){
    this.contact=contact;
    }
    public String getLocation(){
    return location;
    }
    public String getDesscription(){
    return desscription;
    }
    public String geImaget(){
    return image;
    }
    public String getfarm_size(){
    return farm_size;
    }
    public String getFarm_price(){
    return farm_price;
    }
    public String getStatus(){
    return status;
    }
    public String getSales_status(){
    return sales_status;
    }
    public String getContact(){
    return contact;
    }
    
}

