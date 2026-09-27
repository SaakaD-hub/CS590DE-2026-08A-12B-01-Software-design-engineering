# UML toolchain

## Tool choice

**draw.io / diagrams.net.** Free, no trial period, runs in the browser and as a desktop app.

The assignment requires the same UML tool to be available at the midterm, which rules out
anything on a trial licence (Visual Paradigm Community excepted, Lucidchart's free tier is too
limited for a diagram this size).

## Workflow

Diagrams are authored as Mermaid text, then converted to editable UML in draw.io.

1. **Author** the diagram in `diagrams/<name>.mmd`. Text is diffable — a reviewer can see in a
   pull request that `Supplier` changed from value object to entity. A PNG cannot show that.
2. **Verify** it parses at [mermaid.live](https://mermaid.live).
3. **Convert** in draw.io: *Arrange → Insert → Advanced → Mermaid*, paste, insert. This produces
   real draw.io shapes, not an embedded image.
4. **Arrange** the layer containers into side-by-side vertical swimlanes and add a title text box
   (student name, course, date).
5. **Save** the draw.io file as `diagrams/<name>.drawio` — this is the editable master.
6. **Export** *File → Export as → PNG*, with *Selection Only* unchecked, to `diagrams/<name>.png`.

## Known gotcha

draw.io does not render Mermaid — it parses it and rebuilds the diagram as native shapes. The
YAML frontmatter (`---\ntitle: ...\n---`) is document metadata with no shape to map to, so the
title is dropped on import. Add the title as a text box in draw.io instead.

## Why all three files are committed

| File | Purpose | Without it |
|---|---|---|
| `.mmd` | authoring source, diffable in review | changes are invisible in a PR |
| `.drawio` | editable master | the diagram can only be redrawn from scratch |
| `.png` | the hand-in, renders inline on GitHub | the reviewer has to open a tool |
