# Scheduling Algorithm

This repository contains the source code for a scheduling algorithm. A scheduling algorithm is used to manage the execution of multiple processes in a system, ensuring that each process gets a chance to execute. This algorithm is particularly useful in systems with multiple processes competing for limited system resources. This project is a  part of the Operating Systems course at the German International University in Berlin under the supervision of Dr. Hassan Soubra.

## Contents

The repository contains the following main files:

- `process.java`: This file defines the Process class, which represents a process to be scheduled.
- `scheduler.java`: This file contains the scheduling algorithm implementation.

## How It Works

The scheduling algorithm works by maintaining a queue of processes. At each step, the algorithm selects a process from the queue, allows it to execute for a certain amount of time, and then moves on to the next process. This ensures that every process gets a chance to execute.

## Installation

To use this code, you will need to have Java installed on your system and clone the repository using the following command

```
git clone  https://github.com/karim-walid-wahdan/Scheduling-Algorithm.git
```
## Contributing
Contributions to this project are welcome. If you have a feature to suggest or a bug to report, please create a new issue in the GitHub issue tracker.

## License
This project is open-source and is licensed under the MIT License. Please see the LICENSE file for more details.

## Authors

- [Karim Wahdan](https://github.com/karim-walid-wahdan)
- [Mostafa Khalifa](https://github.com/MostKhalifa)
