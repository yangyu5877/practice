/**
 * Created by yangyou on 2018/9/10.
 */
public class Transaction {


    private Currency currency;

    private int price;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Transaction(String _money, int _price) {
        this.currency = new Currency(_money);
        this.price = _price;
    }
    static class Currency {

        private String money;

        public Currency(String _money) {
            this.money = _money;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }
    }
}
