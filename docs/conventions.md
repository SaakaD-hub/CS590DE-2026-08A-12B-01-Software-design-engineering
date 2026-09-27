# Repo conventions

Written down so every lab looks the same and nothing has to be re-decided.

## Naming

| Thing | Rule | Example |
|---|---|---|
| Lab folder | `lab-<zero-padded number>-<kebab-case topic>` | `lab-03-domain-driven-design` |
| Lecture notes | `lesson-<zero-padded number>-<kebab-case topic>.md` | `lesson-03-domain-driven-design.md` |
| Diagram files | `<kind>-diagram.<ext>`, same stem across all three formats | `class-diagram.mmd` / `.drawio` / `.png` |

Zero-padding matters: without it, `lab-10` sorts before `lab-2` in every file listing on earth.

## Commits

[Conventional Commits](https://www.conventionalcommits.org), scoped by lab or lesson.

| Prefix | Use for |
|---|---|
| `feat` | a new lab answer or diagram |
| `fix` | correcting a diagram, answer or classification |
| `docs` | lecture notes, README changes |
| `chore` | repo housekeeping |

One lab per branch (`lab-03`), merged to `main` via PR. The PR body is where I record what
changed after feedback — that history is worth more than a tidy linear log.

## Every lab folder contains

```
labs/lab-NN-topic/
├── README.md        hand-in table first, then the written answer
└── diagrams/        .mmd + .drawio source, .png export
```

The lab README always opens with:

1. A metadata table — student, course, lab, tool, date.
2. A **What to hand in** table mapping each assignment requirement to the file that answers it.
3. The exported diagrams, embedded.

Reasoning comes after. A reader who only wants to mark the work should not have to scroll.

## What this repo deliberately does not have

No CI pipeline, no container, no `src/`. There is no code to build and no test to run — adding
that scaffolding would be noise, not structure. Folders get created when something goes in them.
