/*checks if the value on column COIN is p,n,d,q; but MySQL ignores this constraint*/
CREATE TABLE piggy_bank
(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    coin CHAR(1) CHECK (coin IN ('P','N','D','Q'))
);

SELECT *
FROM piggy_bank;

/*adding CHECK constraint to gender column in my_contacts table*/
/*MySQL ignores constraing, like we didn't even put it*/
ALTER TABLE my_contacts
ADD CONSTRAINT CHECK (gender IN ('M','F'));

DESC my_contacts;

SELECT *
FROM my_contacts;

INSERT INTO my_contacts
(last_name, first_name, phone, email, gender, birthday, profession, city, state, status, location, interests, interest1, interest2, interest3, interest4, seeking)
VALUES
('Ivic','Ivan','555','ivic@nekimail.com','X','1988-09-10','Cook','Belgrade','RS','single','Belgrade,RS','i1','i2','i3','i4','i5','girl');