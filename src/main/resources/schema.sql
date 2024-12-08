-- Create the Users table
CREATE TABLE users (
                       username VARCHAR(255) PRIMARY KEY,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(255) NOT NULL,
                       locked BOOLEAN DEFAULT FALSE,
                       first_name VARCHAR(255),
                       last_name VARCHAR(255),
                       county VARCHAR(255)
);

-- Create the Households table
CREATE TABLE households (
                            eircode VARCHAR(255) PRIMARY KEY,
                            number_of_occupants INT NOT NULL,
                            max_number_of_occupants INT NOT NULL,
                            owner_occupied BOOLEAN NOT NULL
);

-- Create the Pets table
CREATE TABLE pets (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      animal_type VARCHAR(255) NOT NULL,
                      breed VARCHAR(255) NOT NULL,
                      age INT NOT NULL,
                      household_eircode VARCHAR(255),
                      FOREIGN KEY (household_eircode) REFERENCES households(eircode)
);

-- Insert sample data into Users table
INSERT INTO users (username, password, role, first_name, last_name, county)
VALUES
    ('admin@example.com', '$2a$10$9eAiesZdHmhNpWOL7T5nY.7hRjyIWXuPvvTPq1.NFjvgfq1F2amBe', 'ADMIN', 'John', 'Doe', 'Dublin'),
    ('user1@example.com', '$2a$10$9eAiesZdHmhNpWOL7T5nY.7hRjyIWXuPvvTPq1.NFjvgfq1F2amBe', 'USER', 'Jane', 'Doe', 'Cork');

-- Insert sample data into Households table
INSERT INTO households (eircode, number_of_occupants, max_number_of_occupants, owner_occupied)
VALUES
    ('A1B2C3', 2, 4, TRUE),
    ('B4C5D6', 3, 3, FALSE),
    ('C7D8E9', 1, 2, TRUE);

-- Insert sample data into Pets table
INSERT INTO pets (name, animal_type, breed, age, household_eircode)
VALUES
    ('Buddy', 'Dog', 'Golden Retriever', 5, 'A1B2C3'),
    ('Mittens', 'Cat', 'Persian', 3, 'A1B2C3'),
    ('Lucky', 'Dog', 'Labrador', 2, 'B4C5D6'),
    ('Whiskers', 'Cat', 'Siamese', 1, 'C7D8E9');