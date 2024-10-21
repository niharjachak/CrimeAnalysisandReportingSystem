package entity;

public class Officers {

    private int officerId;
    private int BadgeNo;
    private String firstName;
    private String lastName;
    private String rank;
    private String contactInformation;
    private int agencyId;

    public Officers() {
    }

    public Officers(int officerId, int badgeNo,
                    String firstName, String lastName,
                    String rank, String contactInformation,
                    int agencyId) {
        this.officerId = officerId;
        BadgeNo = badgeNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rank = rank;
        this.contactInformation = contactInformation;
        this.agencyId = agencyId;
    }

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public int getBadgeNo() {
        return BadgeNo;
    }

    public void setBadgeNo(int badgeNo) {
        BadgeNo = badgeNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    @Override
    public String toString() {
        return "Officers{" +
                "officerId=" + officerId +
                ", BadgeNo=" + BadgeNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rank='" + rank + '\'' +
                ", contactInformation='" + contactInformation + '\'' +
                ", agencyId=" + agencyId +
                '}';
    }
}
