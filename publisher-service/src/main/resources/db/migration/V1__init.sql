CREATE TABLE publisher (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           url VARCHAR(255) NOT NULL,
                           number_of_ad_spaces INT NOT NULL
);

-- Optional: Insert some sample data
INSERT INTO publisher (name, url, number_of_ad_spaces) VALUES
                                                           ('Tech Blog', 'https://techblog.com', 5),
                                                           ('News Site', 'https://newssite.com', 10),
                                                           ('Lifestyle Magazine', 'https://lifestylemag.com', 3);