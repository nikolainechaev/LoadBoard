INSERT INTO users (username, password, role) VALUES
                                                 ('broker1', 'password1', 'BROKER'),
                                                 ('carrier1', 'password2', 'CARRIER');

INSERT INTO load (pickup_location, delivery_location, offered_price, miles, required_trailer_type, booked_by) VALUES
                                                                                                                  ('Location A', 'Location B', 1000.0, 200.0, 'Flatbed', NULL),
                                                                                                                  ('Location C', 'Location D', 1500.0, 300.0, 'Reefer', NULL);
