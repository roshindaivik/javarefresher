ALTER TABLE campaign ADD COLUMN email VARCHAR(255);

UPDATE campaign SET email = CONCAT('campaign_', id, 'roshin@thealteroffice.com') WHERE email IS NULL;

ALTER TABLE campaign MODIFY email VARCHAR(255) NOT NULL;