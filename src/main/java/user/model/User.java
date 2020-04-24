package user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class User {

    @Id
    private String username;

    @Column(nullable=false)
    private String password;

    @Version
    private long version;

    public User(String username, String password, long version) {
        this.username = username;
        this.password = password;
        this.version = version;
    }

    public User() {
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public long getVersion() {
        return this.version;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        if (this.getVersion() != other.getVersion()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final long $version = this.getVersion();
        result = result * PRIME + (int) ($version >>> 32 ^ $version);
        return result;
    }

    public String toString() {
        return "User(username=" + this.getUsername() + ", password=" + this.getPassword() + ", version=" + this.getVersion() + ")";
    }

    public static class UserBuilder {
        private String username;
        private String password;
        private long version;

        UserBuilder() {
        }

        public User.UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public User.UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User.UserBuilder version(long version) {
            this.version = version;
            return this;
        }

        public User build() {
            return new User(username, password, version);
        }

        public String toString() {
            return "User.UserBuilder(username=" + this.username + ", password=" + this.password + ", version=" + this.version + ")";
        }
    }
}
