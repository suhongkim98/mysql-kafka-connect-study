db.getSiblingDB('admin').auth(
    process.env.MONGO_INITDB_ROOT_USERNAME,
    process.env.MONGO_INITDB_ROOT_PASSWORD
);

db = db.getSiblingDB('x-read-db');

// create collection (x-read-db)
db.createCollection("board");
