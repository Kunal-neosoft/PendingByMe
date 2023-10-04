DELIMITER $$

CREATE PROCEDURE AddContactNumberColumnToCurrentOrder()
BEGIN
    -- Check if the column already exists
    IF NOT EXISTS (
        SELECT COLUMN_NAME
        FROM INFORMATION_SCHEMA.COLUMNS
        WHERE TABLE_NAME = 'tblCurrentOrder'
        AND COLUMN_NAME = 'contact_number'
    ) THEN
        -- Add the 'contact_number' column
        ALTER TABLE tblCurrentOrder
        ADD COLUMN contact_number VARCHAR(255); -- Change the data type and size as needed
    END IF;
END$$

DELIMITER ;