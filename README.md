The purpose of this codebase is to experiment with virtual threads.

A virtual thread will dehydrate the current thread stack if it encounters blocking io, which can mean an HTTP call, writes to a database, or a write to a file.  The thread will then rehydrate once the blocking IO call is complete and continue its execution.

This codebase consists of two parts, and requires some local setup.

First, a local instance of postgres must be running.  This can be accomplished through brew, and the associated sql script will set up the necessary user, database, table and sequence.

Next, the code base:  There exists a server component that returns a simple integer.  This can be started through a ./gradlew bootRun and will run on port 8081.

The client exposes a REST endpoint that does three things:

- invoke the HTTP endpoint on the server component
- write a record to the postgres database
- write a timing record to a file (with a hardcoded path).

These three items are are blocking IO operations.

To execute them in a blocking fashion, invoke the GET operation on localhost:8080/count

To execute them in a virtual thread, invoke the GET operation on localhost:8080/countVirtual

Running JMeter scripts will illustrate some of the different behaviours one might expect.
