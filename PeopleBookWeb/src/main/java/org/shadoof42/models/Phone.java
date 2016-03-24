package org.shadoof42.models;

/**
 * Created by Shadoof on 23.03.2016.
 * Ксласс телефон
 */
public class Phone extends Base{
    /**
     * Номер телефона
     */
    private String phone;
    /**
     * Абонент
     */
    private Abonent abonent;
    /**
     * Тип телефона
     */
    public PhoneType phoneType;

//    public Phone(final String phone,final PhoneType phoneType,final Abonent abonent) {
//        this.phone = phone;
//        this.phoneType = phoneType;
//        this.abonent = abonent;
//    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Abonent getAbonent() {
        return abonent;
    }

    public void setAbonent(Abonent abonent) {
        this.abonent = abonent;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone1 = (Phone) o;

        if (!(phone.equals(phone1.phone)||this.id==phone1.id)) return false;
        return phoneType.equals(phone1.phoneType);

    }

    @Override
    public int hashCode() {
        int result = phone.hashCode();
        result = id + 31 * result + phoneType.hashCode();
        return result;
    }
}
