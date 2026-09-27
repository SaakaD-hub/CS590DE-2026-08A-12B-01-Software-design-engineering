#!/usr/bin/env bash
# Scaffold a new lab folder from the template.
#   bash scripts/new-lab.sh 04 event-driven-architecture "Event Driven Architecture"
set -euo pipefail

NUM="${1:?usage: bash scripts/new-lab.sh <NN> <kebab-topic> \"<Title>\"}"
SLUG="${2:?usage: bash scripts/new-lab.sh <NN> <kebab-topic> \"<Title>\"}"
TITLE="${3:-$SLUG}"

DIR="labs/lab-${NUM}-${SLUG}"
[ -d "$DIR" ] && { echo "error: $DIR already exists" >&2; exit 1; }

mkdir -p "$DIR/diagrams"
sed -e "s/{{NUM}}/${NUM}/g" -e "s/{{TITLE}}/${TITLE}/g" \
    docs/templates/lab-README.md > "$DIR/README.md"

echo "Created $DIR"
echo "Next:"
echo "  1. add diagrams to $DIR/diagrams/  (.mmd + .drawio + .png)"
echo "  2. fill in $DIR/README.md"
echo "  3. add a row to the Labs table in README.md"
