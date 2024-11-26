CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(20) NOT NULL
);

DROP TABLE IF EXISTS load;

CREATE TABLE load (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      pickup_location VARCHAR(255) NOT NULL,
                      delivery_location VARCHAR(255) NOT NULL,
                      offered_price DOUBLE NOT NULL,
                      miles DOUBLE NOT NULL,
                      required_trailer_type VARCHAR(50) NOT NULL,
                      booked_by BIGINT, -- Ensure this column is added
                      FOREIGN KEY (booked_by) REFERENCES users(id)
);

