
public class Quantity {

private String amount;
private Measure kind;

Quantity(String amount, Measure kind){

    this.amount = amount;
    this.kind = kind;
}
public String getAmout(){

    return this.amount;

}
public Measure getKind(){

    return this.kind;
}

}
