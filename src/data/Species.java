/*******************************************************************************
 * Copyright 2010 Alexander Pico
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package data;

/**
 * Acts as a data structure to store the species data as parsed from file species_all.txt
 * @author Anurag Sharma, the user
 */
public class Species {

    public String code, name;

    /**
     * creates new object
     */
    public Species() {
        code = "";
        name = "";
    }


    /**
     * creates new species object with supplied name and code
     * @param code the species code
     * @param name the species name
     */
    public Species(String code, String name) {
        this.code = code;
        this.name = name;

    }

    @Override
    public String toString() {
        return "[S:" + code + "," + name + "]";
    }
}
