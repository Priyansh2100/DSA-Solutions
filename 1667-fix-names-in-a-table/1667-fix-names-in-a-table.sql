SELECT user_id, CONCAT(UPPER(LEFT(name,1)),LOWER(RIGHT(name,LENGTH(name)-1))) AS name
FROM Users ORDER BY user_id;


-- Step 1: LEFT(name,1)
-- LEFT(name,1)

-- Returns the first character.

-- name = "aLice"

-- LEFT(name,1)
--       ↓
--      "a"
-- Step 2: UPPER(LEFT(name,1))
-- UPPER(LEFT(name,1))

-- Converts the first character to uppercase.

-- "a"
--  ↓
-- UPPER()
--  ↓
-- "A"
-- Step 3: LENGTH(name)
-- LENGTH(name)

-- Returns the number of characters.

-- "aLice"

-- Length = 5
-- Step 4: LENGTH(name)-1
-- 5 - 1 = 4

-- We want the remaining 4 characters after the first one.

-- Step 5: RIGHT(name, LENGTH(name)-1)
-- RIGHT(name,4)

-- Returns the last 4 characters.

-- aLice
--  ↑
-- Remove first character

-- RIGHT(name,4)
--       ↓
--     "Lice"
-- Step 6: LOWER(...)
-- LOWER("Lice")

-- Converts everything to lowercase.

-- "Lice"
--    ↓
-- "lice"
-- Step 7: CONCAT(...)
-- CONCAT("A","lice")

-- Joins both strings.

-- "A" + "lice"
--       ↓
--    "Alice"
-- Final Result
-- Original	LEFT	RIGHT	UPPER	LOWER	Final
-- aLice	a	Lice	A	lice	Alice
-- bOB	b	OB	B	ob	Bob