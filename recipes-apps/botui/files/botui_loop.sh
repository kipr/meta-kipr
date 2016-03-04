#!/bin/bash

export DISPLAY=":0"

until botui; do
    echo "botui crashed with exit code $?.  Respawning.." >&2
    sleep 1
done
