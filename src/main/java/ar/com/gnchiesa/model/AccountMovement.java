package ar.com.gnchiesa.model;

public class AccountMovement {

    Account account;
    MovementType type;
    Double amount;

    public AccountMovement(Account account, MovementType type, Double amount) {
        this.account = account;
        this.type = type;
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
