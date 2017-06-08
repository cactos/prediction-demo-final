import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import tools.descartes.dlim.Combinator;
import tools.descartes.dlim.Constant;
import tools.descartes.dlim.DlimFactory;
import tools.descartes.dlim.Function;
import tools.descartes.dlim.Operator;
import tools.descartes.dlim.Sequence;
import tools.descartes.dlim.TimeDependentFunctionContainer;
import tools.descartes.dlim.UniformNoise;

@SuppressWarnings("all")
public class WorkloadSequenceCreator {
  /**
   * Descartes Load Intensity Model Factory
   */
  private DlimFactory df = DlimFactory.eINSTANCE;
  
  private double MAX = (-3.0);
  
  private double MIN = 2.0;
  
  public Sequence createPlayGenSequence() {
    Sequence _createSequence = this.df.createSequence();
    final Procedure1<Sequence> _function = (Sequence it) -> {
      it.setTerminateAfterLoops(1);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment = this.createSegment(28, 10);
      _sequenceFunctionContainers.add(_createSegment);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_1 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_1 = this.createSegment(25, 10);
      _sequenceFunctionContainers_1.add(_createSegment_1);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_2 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_2 = this.createSegment(28, 10);
      _sequenceFunctionContainers_2.add(_createSegment_2);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_3 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_3 = this.createSegment(22, 10);
      _sequenceFunctionContainers_3.add(_createSegment_3);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_4 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_4 = this.createSegment(28, 10);
      _sequenceFunctionContainers_4.add(_createSegment_4);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_5 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_5 = this.createSegment(20, 10);
      _sequenceFunctionContainers_5.add(_createSegment_5);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_6 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_6 = this.createSegment(27, 10);
      _sequenceFunctionContainers_6.add(_createSegment_6);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_7 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_7 = this.createSegment(35, 10);
      _sequenceFunctionContainers_7.add(_createSegment_7);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_8 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_8 = this.createSegment(40, 10);
      _sequenceFunctionContainers_8.add(_createSegment_8);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_9 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_9 = this.createSegment(35, 10);
      _sequenceFunctionContainers_9.add(_createSegment_9);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_10 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_10 = this.createSegment(38, 10);
      _sequenceFunctionContainers_10.add(_createSegment_10);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_11 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_11 = this.createSegment(54, 10);
      _sequenceFunctionContainers_11.add(_createSegment_11);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_12 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_12 = this.createSegment(80, (4 * 60));
      _sequenceFunctionContainers_12.add(_createSegment_12);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_13 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_13 = this.createSegment(100, (4 * 60));
      _sequenceFunctionContainers_13.add(_createSegment_13);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_14 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_14 = this.createSegment(35, (4 * 60));
      _sequenceFunctionContainers_14.add(_createSegment_14);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_15 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_15 = this.createSegment(38, (4 * 60));
      _sequenceFunctionContainers_15.add(_createSegment_15);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_16 = it.getSequenceFunctionContainers();
      TimeDependentFunctionContainer _createSegment_16 = this.createSegment(54, (4 * 60));
      _sequenceFunctionContainers_16.add(_createSegment_16);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_17 = it.getSequenceFunctionContainers();
      this.addReversedCopy(_sequenceFunctionContainers_17);
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_18 = it.getSequenceFunctionContainers();
      final Consumer<TimeDependentFunctionContainer> _function_1 = (TimeDependentFunctionContainer it_1) -> {
        this.addNoise(it_1);
      };
      _sequenceFunctionContainers_18.forEach(_function_1);
      for (int i = 0; (i < 3); i++) {
        {
          EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_19 = it.getSequenceFunctionContainers();
          Collection<TimeDependentFunctionContainer> _copyAll = EcoreUtil.<TimeDependentFunctionContainer>copyAll(_sequenceFunctionContainers_19);
          LinkedList<TimeDependentFunctionContainer> tempCopy = new LinkedList<TimeDependentFunctionContainer>(_copyAll);
          final Consumer<TimeDependentFunctionContainer> _function_2 = (TimeDependentFunctionContainer it_1) -> {
            this.addNoise(it_1);
          };
          tempCopy.forEach(_function_2);
          EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_20 = it.getSequenceFunctionContainers();
          Iterables.<TimeDependentFunctionContainer>addAll(_sequenceFunctionContainers_20, tempCopy);
        }
      }
      EList<TimeDependentFunctionContainer> _sequenceFunctionContainers_19 = it.getSequenceFunctionContainers();
      this.addReversedCopy(_sequenceFunctionContainers_19);
    };
    return ObjectExtensions.<Sequence>operator_doubleArrow(_createSequence, _function);
  }
  
  public boolean addReversedCopy(final EList<TimeDependentFunctionContainer> sequenceFunctionContainers) {
    boolean _xblockexpression = false;
    {
      Collection<TimeDependentFunctionContainer> _copyAll = EcoreUtil.<TimeDependentFunctionContainer>copyAll(sequenceFunctionContainers);
      LinkedList<TimeDependentFunctionContainer> reversed = new LinkedList<TimeDependentFunctionContainer>(_copyAll);
      Collections.reverse(reversed);
      _xblockexpression = Iterables.<TimeDependentFunctionContainer>addAll(sequenceFunctionContainers, reversed);
    }
    return _xblockexpression;
  }
  
  public TimeDependentFunctionContainer addNoise(final TimeDependentFunctionContainer in) {
    Function _function = in.getFunction();
    EList<Combinator> _combine = _function.getCombine();
    Combinator _createCombinator = this.df.createCombinator();
    final Procedure1<Combinator> _function_1 = (Combinator it) -> {
      it.setOperator(Operator.ADD);
      UniformNoise _createUniformNoise = this.df.createUniformNoise();
      final Procedure1<UniformNoise> _function_2 = (UniformNoise it_1) -> {
        it_1.setMax(this.MAX);
        it_1.setMin(this.MIN);
      };
      UniformNoise _doubleArrow = ObjectExtensions.<UniformNoise>operator_doubleArrow(_createUniformNoise, _function_2);
      it.setFunction(_doubleArrow);
    };
    Combinator _doubleArrow = ObjectExtensions.<Combinator>operator_doubleArrow(_createCombinator, _function_1);
    _combine.add(_doubleArrow);
    return in;
  }
  
  public TimeDependentFunctionContainer createSegment(final int intensity, final double length) {
    TimeDependentFunctionContainer _createTimeDependentFunctionContainer = this.df.createTimeDependentFunctionContainer();
    final Procedure1<TimeDependentFunctionContainer> _function = (TimeDependentFunctionContainer it) -> {
      it.setDuration(length);
      Constant _createConstant = this.df.createConstant();
      final Procedure1<Constant> _function_1 = (Constant it_1) -> {
        it_1.setConstant(intensity);
      };
      Constant _doubleArrow = ObjectExtensions.<Constant>operator_doubleArrow(_createConstant, _function_1);
      it.setFunction(_doubleArrow);
    };
    return ObjectExtensions.<TimeDependentFunctionContainer>operator_doubleArrow(_createTimeDependentFunctionContainer, _function);
  }
}
