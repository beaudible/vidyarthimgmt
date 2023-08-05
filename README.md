# Vidyarthi Management

### Helpful commands for local

* Build Application `./gradlew build` or `.gradlew clean build`
* Creating shadowJar `./gradlew clean shadowJar`
* Checkstyle `./gradlew checkstyleMain` or `./gradlew checkstyleTest`


### Reference Documentation

* [Greet API](http://localhost:15000/ashram/api/v1/vidyarthi/greet)

### Git create new branch command

```
git checkout -b branchName sourceBranchName
```
### Steps to setup github actions

* Click on repository's Action tab
* Rename name's value of auto generate yml and rename file to pipeline.yml
* Commit changes and raise PR in separate branch
* You can now check Action, you will see CI being executed
* You'll probably get an error saying issue with gradlew. It can be fixed by adding execute permission to gradlew file
    * Checkout your branch in local and run `git update-index --chmod=+x gradlew` Command to add execute permission
    * Now commit and push your changes. Your error will be resolved
    * Job well Done!