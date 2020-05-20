# Use GIT-Flow branching model.
We'll follow the [GIT-Flow branching model](https://nvie.com/posts/a-successful-git-branching-model/) for our development 
flow. When our Continuous Development process has been fully implemented, we will switch to the 
[GitHub flow](https://guides.github.com/introduction/flow/).

## How should we structure our repositories?
* Should we impose a git flow on our development process?
* If so, which flow should we use?

## Considered Options
* No model (current)
* [GIT-Flow branching model](https://nvie.com/posts/a-successful-git-branching-model/)
* [GitHub flow](https://guides.github.com/introduction/flow/)

## Decision Outcome
Currently, no model is in place. This (among other causes) leads to loss of information in the repository, making it 
harder to read into past decisions and developments. Therefor, we would like to adopt a flow model to counter this. 

Ideally, we would like to use the Github flow, for its simplicity. However, this requires a full-fledged Continuous 
Development process in place.

The older model allows us to quickly revert to previous versions, test releases separate from production and manually catch 
regressions usually caught by the test suite. It thus helps us to guarantee the quality by hand. 

### Positive Consequences 
* We gain more insight into the history of the development…
* Quality of the deployed releases can be monitored more securely.
* Can be automated via git-flow

### Negative Consequences
* Puts a (minor) administrative burden on development
