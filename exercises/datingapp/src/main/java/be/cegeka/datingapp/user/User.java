package be.cegeka.datingapp.user;

import be.cegeka.datingapp.core.InstanceBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String surName;
    private List<String> personalityTraits;
    private int age;

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public List<String> getPersonalityTraits() {
        return new ArrayList<>(personalityTraits);
    }

    public String getInfo() {
        String traits = getPersonalityString();
        return String.format("Hello, my name is %s %s. I am %d years old and I am %s.", name, surName, age, traits);
    }

    private String getPersonalityString() {
        String traits = personalityTraits.get(personalityTraits.size() - 1);
        if (personalityTraits.size() > 1) {
            List<String> firstTraits = personalityTraits.subList(0, personalityTraits.size() - 1);
            String joinedTraits = String.join(", ", firstTraits);
            traits = String.format("%s and %s", joinedTraits, traits);
        }
        return traits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .append(age, user.age)
                .append(name, user.name)
                .append(surName, user.surName)
                .append(personalityTraits, user.personalityTraits)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(surName)
                .append(personalityTraits)
                .append(age)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("surName", surName)
                .append("personalityTraits", personalityTraits)
                .append("age", age)
                .toString();
    }

    public static class Builder extends InstanceBuilder<User> {
        public Builder withName(String name) {
            instance.name = name;
            return this;
        }

        public Builder withSurName(String surName) {
            instance.surName = surName;
            return this;
        }

        public Builder withPersonalityTraits(List<String> personalityTraits) {
            instance.personalityTraits = personalityTraits;
            return this;
        }

        public Builder withAge(int age) {
            instance.age = age;
            return this;
        }

        @Override
        protected User instance() {
            return new User();
        }
    }
}
