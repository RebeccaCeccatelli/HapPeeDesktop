package backend;

import java.sql.Time;

public class Business extends Account {
    private BusinessDetails details;

    public Business(int id) {
        super(id);
        this.details = new BusinessDetails(id);
    }

    public void saveBusinessType(String businessType) {
        details.saveBusinessType(businessType);
    }

    public void saveAccessPrice(double accessPrice) {
        details.saveAccessPrice(accessPrice);
    }

    public void saveAccessCode(int accessCode) { details.saveAccessCode(accessCode); }

    public void saveTime(Time time, String type) {
        details.saveTime(time, type);
    }

    public BusinessDetails getDetails() {
        return details;
    }

    protected String getIdType() {
        return "business_id";
    }

    public int getAccessCode() {
        return details.getAccessCode();
    }

    public double getAverageRating() {
        double average = 0;
        if (reviews.size() != 0) {
            for (Review review : reviews) {
                average += review.getRating();
            }
            return average / reviews.size();
        }
        return average;
    }

    protected AccountInformation retrieveAccountInformation(int id) {
        return new BusinessInformation(id);
    }

    public static boolean equals(Business first, Business second) {
        if (BusinessInformation.equals(first.getInformation(), second.getInformation())) {
            if (BusinessDetails.equals(first.getDetails(), second.getDetails())) {
                if (first.getReviews().size() == second.getReviews().size()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
