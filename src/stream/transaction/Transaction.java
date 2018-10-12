package stream.transaction;

/**
 * Created by yangyou on 2018/10/8.
 */
public class Transaction {

    private Trader trader;
    private int year;
    private int value;
    private String currency;


    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Transaction(String currency) {
        this.currency = currency;
    }

    public Transaction(int value) {
        this.value = value;
    }


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "hahha ";
    }


}
