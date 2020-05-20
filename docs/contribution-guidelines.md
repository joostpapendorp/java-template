# Contribution Guidelines

#### Writing tests 
We use [TDD](https://en.wikipedia.org/wiki/Test-driven_development) to develop our code. See also the [ADR](adr/0001-test-driven-development.md)

#### Code review 
Four eyes principle, merges only via pull requests.

#### Documentation and maintenance
We use in-repo docs, using ADRs. We encourage contributors to add new records when making design choices. See the 
[ADR index](docs/adr/index.md) for relevant information and guidelines.

### Repository use
##### Committing strategy
The GIT repository is a important source of information on past choices. `git blame` is a useful tool to review past 
changes in-code (Intellij's context menu item is *git > annotate*). 

Secondly, all the commits on a single branch should 
tell a story explaining to reviewers how, what and most importantly, why the changes were applied. A good feature branch
tells that story step by step, with the merge commit detailing the total delta versus develop. 

To achieve this, please try to adhere to the following:  
* Keep commits small; one relevant change per commit. Break up larger work by committing multiple times. `--amend`
relevant changes if necessary before pushing a commit.
* Add useful description in the commit message. This includes
    - the issue number, if applicable
    - description of containing story
    - description of changes contained within the commit, focusing on the why, not the how.
* Include tests to relevant code changes. Do not commit untested changes. Make sure all tests pass before committing.

Example of a good commit message:
> [JRP-9] Document release management.  
> Added committing guide lines. Clarified versioning guide lines.

##### Branching model
We use the common [git branching model](https://nvie.com/posts/a-successful-git-branching-model/). See also [the ADR](/docs/adr/0003-git-branching-model.md).
Please read it  carefully if you are not yet familiar with it. *) Applying the model to our process requires:

* No committing on `master`. Only release branches are merged, via pull requests.
* No committing on `develop`. Merging is done via pull requests
* Releases are built using release branches, see [below](#release-guide)
* All merging, via pull requests or otherwise, is done using `--no-ff`, to preserve the branching structure  
* Features branches are branched from `develop` and follow the naming scheme `feature/ISSUE_descriotion-with-dashes`, 
with `ISSUE` being the Jira issue number, e.g. `feature/VXC-71_document-release-management`
* Any merge conflicts between `develop` and the feature branch must be resolved in the feature branch, prior to merging, 
i.e. the merge commit should not resolve conflicts. The pull request will indicate if there are merge conflicts. If this
is the case, first `git merge develop --no-ff` into the feature branch and resolve them.
* To avoid `merged origin/branch into branch`-commits when collaborating on the same branch, pull before each push, 
using `git pull --rebase -p origin` (I recommend to alias this command as e.g. `safe-pull`)

> *) While the [GitHub flow](https://guides.github.com/introduction/flow/) is preferable, merging directly into `master` requires
>   solid Continuous Deployment practices to be into place. Since this is not the case, most notably due to an absence of 
>   adequate test coverage, we are stuck with the more rigorous older model for now. As soon as the CD is in place, we will 
>   switch to the GitHub model. See the [ADR](adr/0003-git-branching-model.md) for details.

##### Repository maintenance
Keeping the repo clean helps efficiency as it avoids considering old dead branches. Following 
[this post](https://railsware.com/blog/git-housekeeping-tutorial-clean-up-outdated-branches-in-local-and-remote-repositories/)
ensures this. Useful tips include:
* Automatically remove feature branches in pull requests by enabling the `close branch` option at the bottom.
* Manually remove a merged branch with `git branch -d` or using SourceTree
* Regularly pruning the repo using `git prune` and `git remote prune origin`. 
* Pull using `git pull --rebase -p origin` prunes automatically

### Release guide
##### building a release
with the current version from the `develop` branch at `[x.y]-SNAPSHOT`:
1. Branch `release/[x.y]` from `develop`.
2. *(optional)* bump version of `release/[x.y]` to `[x.y]-RC`
3. *(optional)* deploy `release/[x.y]` to test
4. *(optional)* branch any release bug fixes from `release/[x.y]` and merge back when fixed.
5. Update the [release notes](release-notes.md) with all the issues in this release.
6. bump version of `release/[x.y]` to `[x.y]-RELEASE`
7. merge `release/[x.y]` via pull request `--no-ff` into `master`
8. tag this merge commit on `master` with `v[x.y]` and push `--tags`
9. bump version of `release/[x.y]` to next snapshot (`[x.z]-SNAPSHOT`). Use [guide lines](#versioning-guide-lines) below.
10. merge via pull request `--no-ff` back into `develop` and delete the `release/[x.y]` branch.

##### Versioning guide lines
* Major release when 
    - API breaking changes
    - non-trivial changes in existing processes or functionality
    - (own) deprecation removal
* Minor release, otherwise

##### Deprecation and removal
Broadly speaking, deprecation can be divided into three groups.
- deprecation from library usage
- internal deprecation and
- externally exposed deprecation

Deprecation from library usage is usually introduced by upgrading dependencies. It should ideally be fixed directly 
when encountered.

When deprecating internal code, e.g. when splitting up larger refactors, add information on how to migrate to the new situation and include the 
current version number to the `@Deprecated` annotation. Internal deprecated api should be removed within two minor 
versions, e.g. if api is marked as deprecated in v1.1, it will be removed with the 1.3 release.

When deprecating externally exposed api, this deprecated api will be removed in the next major release.

### Other guidelines  
This project, its docs and its code are written in English.
