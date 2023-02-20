CREATE TABLE IF NOT EXISTS better_reads.author_by_id (
    author_id       text PRIMARY KEY,
    author_name     text,
    personal_name   text
);

CREATE TABLE IF NOT EXISTS better_reads.book_by_id (
    id               text PRIMARY KEY,
    author_id        list<text>,
    author_names     list<text>,
    book_description text,
    book_name        text,
    cover_ids        list<text>,
    published_date  date
);

CREATE TABLE IF NOT EXISTS better_reads.book_by_user_and_bookid (
    user_id         text,
    book_id         text,
    completed_date  date,
    rating          int,
    reading_status  text,
    started_date    date,
    PRIMARY KEY ((user_id, book_id))
);

CREATE TABLE IF NOT EXISTS better_reads.books_by_user (
    user_id         text,
    readingstatus   text,
    timeuuid        timeuuid,
    book_id         text,
    author_names    list<text>,
    book_name       text,
    cover_ids       list<text>,
    rating          int,
    PRIMARY KEY (user_id, readingstatus, timeuuid, book_id)
) WITH CLUSTERING ORDER BY (readingstatus ASC, timeuuid DESC, book_id ASC);

 





