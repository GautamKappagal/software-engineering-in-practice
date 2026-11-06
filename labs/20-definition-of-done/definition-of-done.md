# Definition of Done — team-inventory

Apply this checklist to every future change in `examples/team-inventory`,
regardless of the implementation language.

- [ ] The track's documented automated test command exits with status 0 on the final commit.
- [ ] The change has a focused automated test that demonstrates each new or changed observable behavior.
- [ ] Any README, API description, or user-facing example affected by the change is updated in the same pull request, or the pull request explicitly says that none are affected.
- [ ] A pull request to this repository's `main` branch explains what changed, why it changed, and the command(s) used to verify it.
- [ ] At least one reviewer has recorded an approval or actionable review comment; every actionable comment is resolved in the pull request before merge.
- [ ] The pull request is merged into `main`, and its final CI run is successful with no required check skipped or failing.

## Retrospective: Lab 18 — Pull requests and review

The change was merged as PR #1, `feature/reorder-report`, in commit
`b80bb93` (`Merge pull request #1 from GautamKappagal/feature/reorder-report`).
The review record is in
[`my-review-notes.md`](../18-pull-requests-and-review/my-review-notes.md).

| Definition-of-Done item | Actual outcome | Result |
| --- | --- | --- |
| Automated test command exits 0 | The lab required `./gradlew test`; the merged change includes `InventoryTest` coverage for the report. The lab record states the track test command passed after the merge. | Yes |
| Focused automated test covers changed behavior | The review note records tests for both the empty result and the exact low-stock report output. | Yes |
| Affected documentation is updated or explicitly ruled out | The available PR/review record does not say whether README, API, or example documentation was affected. | No — this was not recorded. |
| PR explains what, why, and verification | Lab 18's acceptance record and the review note establish the what and why, but the local evidence retained here does not preserve the PR description or its verification commands. | No — cannot verify from the retained record. |
| Review is recorded and actionable comments resolved | The solo review found a duplicate import, and commits `041fcda` and `ae1ec68` record its removal and the review fix. | Yes |
| Merged to `main` with successful CI | The PR was merged, but CI was only introduced in Lab 19 (`922eda9`), after this Lab 18 PR. | No — no CI run existed for this change. |
