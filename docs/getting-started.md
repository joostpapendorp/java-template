# Getting started.
Hi and welcome to the project! 

This guide helps you to get up and running as efficiently as possible. It provides 
step-by-step instructions for installing, running and deploying [...].

As with all guides, this is a continual work-in-progress, as the app changes over time. 

**Please make sure to document your installation process and update this guide where needed!** 

As the latest user of this guide *you* will become the expert  on the current installation process. By maintaining this 
guide, you help our future collaborators to contribute.

Enjoy and happy contributing,  
 Joost Papendorp, march 2020

### Installs
To build and run this project, you will require the following tools:

##### Java SDK
[...] uses the latest LTS (long term support) release of the Java SDK. We use the [OpenJDK](https://jdk.java.net/)
release, since Oracle changed the licensing with the LTS 11 release, making it unavailable for commercial use without a
commercial license. OpenJDK releases remain all-purpose.

##### IDE
The preferred IDE for this project is [Intellij](https://www.jetbrains.com/idea/). It's fine if you prefer to use a 
different IDE, but then you are on your own.

##### SCM
We use [GIT](https://git-scm.com/downloads) as our versioning tool. In addition, we recommend using a visualization
tool, such as [Sourcetree](https://www.sourcetreeapp.com/).  

##### Maven
[Maven 3.1.0 or above](https://maven.apache.org/download.cgi) is required to build the project.

### Accounts
In addition, you require access to the following:
- [Issue tracker]([...])
- [...]

### Build and run locally
[...]

### Deploy
##### Deploy to test
Presently, no testing environment exists.

##### Deploy to production
[...]

### Tools and commands
the following tools are useful in developing and maintaining the backend:  
- [OWASP dependency checker](https://owasp.org/www-project-dependency-check/). To check our dependencies for vulnerabilities, run `mvn verify > docs/temp/OWASP.txt`. 
Run it twice to get rid of the extraneous download logging.
- [Maven versions plugin](https://www.mojohaus.org/versions-maven-plugin/). To quickly check for new updates for our dependencies, run `mvn versions:display-dependency-updates > docs/temp/dependencies.txt`,
also twice. This is not foolproof, however, as it might miss updates that require different dependencies. It also 
recommends snapshots or malformed version 'numbers', but it is quite useful as a regular quick scan.    
- [ADR-log](docs/adr/index.md#tooling). Run the command `adr-log -i` inside `/docs/adr/` to update the index. 
- [Lombok](https://projectlombok.org/). Requires annotation processing to be enabled.

