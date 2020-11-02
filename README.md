# prime

Maven project that parsers Excel 2007-2013 (xlsx) file and prints all prime numbers found in the file.

To build it, you will need to download and unpack the latest (or recent) version of Maven (https://maven.apache.org/download.cgi)
and put the `mvn` command on your path.

Then, you will need to install a Java 1.8 (or higher) JDK, and make sure you can run `java` from the command line.
Now you can run `mvn clean package` and Maven will compile project and put the results it in two jar files in the `target` directory.

To run from command line execute `java -jar target/prime-1.0-SNAPSHOT-shaded.jar -f pathToFile`,
where `pathToFile` is path to xlsx file.

You can run the code also by using an IDE like [NetBeans](https://netbeans.org/), [Intellij IDEA](https://www.jetbrains.com/idea/), or [Eclipse](https://eclipse.org/ide/).