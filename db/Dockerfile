# Use sql version that works.
FROM mysql:8.0
# Set the working directory
WORKDIR /tmp
# Copy all the files to the working directory of the container
COPY world-db/world.sql /tmp/
# startup script
COPY world-db/world.sql /docker-entrypoint-initdb.d
# Set the root password
ENV MYSQL_ROOT_PASSWORD p@sswdr00t