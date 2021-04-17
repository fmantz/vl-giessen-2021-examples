//scalastyle:off
/*
 * Simple examples explaining FP concepts
 * Copyright (C) 2021 Florian Mantz
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
//scalastyle:on
package de.fmantz.fp.examples.simplepattern;

import java.util.ArrayList;

public class BuildInPatternJava {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        //Print even numbers by power of 2 between [1,10]
        numbers
                .stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .forEach(System.out::println);

        //There are many more, like max, min, count ... (check the API)

    }
}
