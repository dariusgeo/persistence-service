package ro.orange.service2.model;

public enum EInteractionType {
    PAYER(1),
    PAYEE(2);

    private final int id;

    EInteractionType(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
