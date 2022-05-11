import { danger, message, warn } from 'danger';

var isGood = true;

const diffSize = Math.max(danger.github.pr.additions, danger.github.pr.deletions);
if (diffSize > 300 ) {
    warn("This PR is too big. You should divide this PR into smaller PRs.");
    isGood = false;
}

for (const commit of danger.github.commits) {
    if (commit.commit.message.length < 5) {
        warn("There is a commit with very short message: " +  commit.commit.message)
        isGood = false;
    }
}

if (isGood) {
    message("This PR looks good :)")
}