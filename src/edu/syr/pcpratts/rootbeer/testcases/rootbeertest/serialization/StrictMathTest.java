/* 
 * Copyright 2012 Phil Pratt-Szeliga and other contributors
 * http://chirrup.org/
 * 
 * See the file LICENSE for copying permission.
 */

package edu.syr.pcpratts.rootbeer.testcases.rootbeertest.serialization;

import edu.syr.pcpratts.rootbeer.runtime.Kernel;
import edu.syr.pcpratts.rootbeer.test.TestSerialization;

import org.trifort.rootbeer.remap.java.util.ArrayList;
import org.trifort.rootbeer.remap.java.util.List;

public class StrictMathTest implements TestSerialization {

  @Override
  public List<Kernel> create() {
    List<Kernel> ret = new ArrayList<Kernel>();
    for(int i = 0; i < 20; ++i){
      ret.add(new StrictMathRunOnGpu());
    }
    return ret;    
  }

  @Override
  public boolean compare(Kernel lhs, Kernel rhs) {
    StrictMathRunOnGpu glhs = (StrictMathRunOnGpu) lhs;
    StrictMathRunOnGpu grhs = (StrictMathRunOnGpu) rhs;
    
    if(glhs.compare(grhs) == false){
      return false;
    }
    return true;    
  }

  
}
