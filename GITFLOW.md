# Git workflow when making changes *in progress*

## everyday

to keep your main branch up-to-date `git pull origin main`
Default to working in a seperate branch from main

- view branches locally `git branch`
- view all branches `git branch -a`

## When starting a new implementation

`git pull main origin`
`git checkout -b <branch>`
if you created branch already `git branch <branch>`

### *implement code ready to push for review*

`git fetch origin main`
to view differences in terminal `git diff`

### *fetch head of main-branch to resolve merge issues*

`git push origin <branch>`

### *create pull request with your branch to the main branch*

A teamate will review your pull request and accept the merge.

## troubleshooting issues

case 1: you forgot to fetch/pull the main branch before working on your changes or switching branches
`git stash`
`git pull`
`git stash pop`
[gitStash](https://git-scm.com/docs/git-stash)

## review

`git log`
`git diff`
