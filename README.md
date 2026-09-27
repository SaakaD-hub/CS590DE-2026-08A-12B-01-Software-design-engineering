# CS590DE — Software Design Engineering

**Student:** David Kasozi Saaka (<davidkasozisaaka@gmail.com>)
**Section:** 2026-08A-12B-01
**UML tool:** draw.io / diagrams.net — used for every lab and for the midterm

Lab submissions for CS590DE. Each lab folder is self-contained: the hand-in files are listed
and shown at the top of its README, with the reasoning below.

## Labs

| Lab | Topic | Hand-in | Status |
|-----|-------|---------|--------|
| 03 | [Domain Driven Design — webshop](labs/lab-03-domain-driven-design/) | class diagram, sequence diagram | ✅ submitted |

## Layout

```
.
├── docs/
│   ├── conventions.md                 repo conventions — naming, commits, diagram workflow
│   ├── uml-toolchain.md               how diagrams are authored, rendered and exported
│   └── lessons/                       my notes on each lecture
│       └── lesson-03-domain-driven-design.md
├── labs/
│   └── lab-03-domain-driven-design/
│       ├── README.md                  the submission: hand-in files + written answer
│       └── diagrams/
│           ├── class-diagram.mmd      Mermaid source  (authoring)
│           ├── class-diagram.drawio   draw.io source  (editable master)
│           └── class-diagram.png      export          (hand-in)
└── scripts/
    └── init-repo.sh
```

Three rules keep it navigable:

1. **One folder per lab, identical shape.** Anyone who has opened one lab folder can navigate
   all of them.
2. **Source lives next to output.** The `.png` is the hand-in; the `.mmd` and `.drawio` are what
   let the diagram be corrected and re-exported later. A committed PNG with no source is a dead
   artifact.
3. **Notes are separate from answers.** `docs/lessons/` holds what I took from the lecture;
   the lab README holds the answer. Mixing them makes both harder to read.

## Conventions

Commits follow [Conventional Commits](https://www.conventionalcommits.org), scoped by lab:

```
feat(lab03): DDD webshop class and sequence diagrams
fix(lab03): correct Supplier stereotype to entity
docs(lesson03): notes on value objects vs entities
```

Full detail in [`docs/conventions.md`](docs/conventions.md).
