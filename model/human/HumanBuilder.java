package model.human;

import java.time.LocalDate;

public class HumanBuilder {
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;

    public HumanBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public HumanBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public HumanBuilder withDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Human build() {
        return new Human(name, gender, dateOfBirth);
    }
}
