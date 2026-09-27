#!/usr/bin/env bash
# One-time setup. Run from the repo root:
#     bash scripts/init-repo.sh
set -euo pipefail

REMOTE="https://github.com/SaakaD-hub/CS590DE-2026-08A-12B-01-Software-design-engineering.git"

git init
git config user.name  "David Kasozi Saaka"
git config user.email "davidkasozisaaka@gmail.com"
git branch -M main

git add .gitignore README.md docs scripts
git commit -m "chore: repo layout, conventions and UML toolchain notes"

git add labs
git commit -m "feat(lab03): DDD webshop class and sequence diagrams

Part 1 - labs/lab-03-domain-driven-design/diagrams/class-diagram.png
Part 2 - labs/lab-03-domain-driven-design/diagrams/sequence-diagram.png

Four-layer architecture (service, domain, data access, integration) with each
domain class classified as entity, value object, domain service or domain event."

git remote add origin "$REMOTE"
git push -u origin main

echo
echo "Send your lecturer:"
echo "  https://github.com/SaakaD-hub/CS590DE-2026-08A-12B-01-Software-design-engineering/tree/main/labs/lab-03-domain-driven-design"
